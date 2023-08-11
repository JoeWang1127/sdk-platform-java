#!/usr/bin/env bash

set -e

# define utility functions
extract_folder_name() {
  destination_path=$1
  folder_name=${destination_path##*/}
  echo "$folder_name"
}
remove_empty_files() {
  category=$1
  find "$library_gen_out/$destination_path/$category-$folder_name/src/main/java" -type f -size 0 | while read -r f; do rm -f "${f}"; done
  if [ -d "$library_gen_out/$destination_path/$category-$folder_name/src/main/java/samples" ]; then
      mv "$library_gen_out/$destination_path/$category-$folder_name/src/main/java/samples" "$library_gen_out/$destination_path/$category-$folder_name"
  fi
}

mv_src_files() {
  category=$1 # one of gapic, proto, samples
  type=$2 # one of main, test
  if [ "$category" == "samples" ]; then
    folder_suffix="samples/snippets/generated"
    src_suffix="samples/snippets/generated/src/main/java/com"
  elif [ "$category" == "proto" ]; then
    folder_suffix="$category-$folder_name/src/$type"
    src_suffix="$category/src/$type/java"
  else
    folder_suffix="$category-$folder_name/src/$type"
    src_suffix="src/$type/java"
  fi
  mkdir -p "${library_gen_out}/$destination_path/$folder_suffix"
  cp -r "$library_gen_out/$destination_path/java_gapic_srcjar/$src_suffix" "$library_gen_out/$destination_path/$folder_suffix"
  if [ "$category" != "samples" ]; then
    rm -r -f "$library_gen_out/$destination_path/$folder_suffix/java/META-INF"
  fi
}

# unzip jar file
unzip_src_files() {
  category=$1
  jar_file=java_$category.jar
  mkdir -p "$library_gen_out/$destination_path/$category-$folder_name/src/main/java"
  unzip -q -o "$library_gen_out/$destination_path/$jar_file" -d "$library_gen_out/$destination_path/$category-$folder_name/src/main/java"
  rm -r -f "$library_gen_out/$destination_path/$category-$folder_name/src/main/java/META-INF"
}

find_additional_protos_in_yaml() {
  PATTERN=$1
  FIND_RESULT=$(grep --include=\*.yaml -rw "${proto_path}" -e "${PATTERN}")
  if [ -n "${FIND_RESULT}" ]; then
    echo "${FIND_RESULT}"
  fi
}

search_additional_protos() {
  ADDITIONAL_PROTOS="google/cloud/common_resources.proto" # used by every library
  IAM_POLICY=$(find_additional_protos_in_yaml "name: google.iam.v1.IAMPolicy")
  if [ -n "${IAM_POLICY}" ]; then
    ADDITIONAL_PROTOS="${ADDITIONAL_PROTOS} google/iam/v1/iam_policy.proto"
  fi
  LOCATIONS=$(find_additional_protos_in_yaml "name: google.cloud.location.Locations")
  if [ -n "${LOCATIONS}" ]; then
    ADDITIONAL_PROTOS="${ADDITIONAL_PROTOS} google/cloud/location/locations.proto"
  fi
  echo "${ADDITIONAL_PROTOS}"
}

get_gapic_opts() {
  gapic_config=$(find "${proto_path}" -type f -name "*gapic.yaml")
  if [ -z "${gapic_config}" ]; then
    gapic_config=""
  else
    gapic_config="gapic-config=$gapic_config,"
  fi
  grpc_service_config=$(find "${proto_path}" -type f -name "*service_config.json")
  api_service_config=$(find "${proto_path}" -maxdepth 1 -type f \( -name "*.yaml" ! -name "*gapic.yaml" \))
  if [ "${rest_numeric_enums}" == "true" ]; then
    rest_numeric_enums="rest-numeric-enums,"
  else
    rest_numeric_enums=""
  fi
  echo "transport=$transport,${rest_numeric_enums}grpc-service-config=$grpc_service_config,${gapic_config}api-service-config=$api_service_config"
}