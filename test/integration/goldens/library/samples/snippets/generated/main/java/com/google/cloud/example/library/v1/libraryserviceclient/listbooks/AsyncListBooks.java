/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.example.library.v1.samples;

// [START library_v1_generated_libraryserviceclient_listbooks_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.example.library.v1.LibraryServiceClient;
import com.google.example.library.v1.Book;
import com.google.example.library.v1.ListBooksRequest;
import com.google.example.library.v1.ShelfName;

public class AsyncListBooks {

  public static void main(String[] args) throws Exception {
    asyncListBooks();
  }

  public static void asyncListBooks() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
      ListBooksRequest request =
          ListBooksRequest.newBuilder()
              .setParent(ShelfName.of("[SHELF_ID]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      ApiFuture<Book> future = libraryServiceClient.listBooksPagedCallable().futureCall(request);
      // Do something.
      for (Book element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END library_v1_generated_libraryserviceclient_listbooks_async]