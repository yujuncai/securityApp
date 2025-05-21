/*
 * Copyright (c) 2025-2025, fubluesky (fubluesky@foxmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ai.reactive.securityApp.support.dify.dataset.constant;

/**
 * @author j
 * @version 1.0
 * @since 2025/3/13 11:34
 */
public interface DatasetUriConstant {

    String V1_URL = "/v1";

    String V1_DATASETS_URL = V1_URL + "/datasets";

    String V1_DATASET_URL = V1_DATASETS_URL + "/{datasetId}";

    String V1_DOCUMENTS_URL = V1_DATASET_URL + "/documents";

    String V1_DOCUMENT_CREATE_BY_TEXT_URL = V1_DATASET_URL + "/document/create-by-text";

    String V1_DOCUMENT_CREATE_BY_FILE_URL = V1_DATASET_URL + "/document/create-by-file";

    String V1_DOCUMENT_URL = V1_DOCUMENTS_URL + "/{documentId}";

    String V1_DOCUMENT_INDEXING_STATUS_URL = V1_DOCUMENTS_URL + "/{batch}/indexing-status";

    String V1_DOCUMENT_UPDATE_BY_TEXT_URL = V1_DOCUMENT_URL + "/update-by-text";

    String V1_DOCUMENT_UPDATE_BY_FILE_URL = V1_DOCUMENT_URL + "/update-by-file";

    String V1_DOCUMENTS_SEGMENTS_URL = V1_DOCUMENT_URL + "/segments";

    String V1_DOCUMENTS_SEGMENT_URL = V1_DOCUMENT_URL + "/segments/{segmentId}";

    String V1_DOCUMENTS_SEGMENTS_CHILD_CHUNKS_URL = V1_DOCUMENTS_SEGMENT_URL + "/child_chunks";

    String V1_DOCUMENTS_SEGMENTS_CHILD_CHUNK_URL = V1_DOCUMENTS_SEGMENT_URL + "/child_chunks/{child_chunk_id}";

    String V1_DOCUMENTS_UPLOAD_FILE = V1_DOCUMENT_URL + "/upload-file";

    String V1_DATASETS_RETRIEVE_URL = V1_DATASET_URL + "/retrieve";

    String V1_METADATA_CREATE_URL = V1_DATASET_URL + "/metadata";

    String V1_METADATA_UPDATE_URL = V1_METADATA_CREATE_URL + "/{metadataId}";

    String V1_METADATA_DELETE_URL = V1_METADATA_UPDATE_URL;

    String V1_METADATA_ACTION_URL = V1_METADATA_CREATE_URL + "/built-in/{action}";

    String V1_DOCUMENT_METADATA_UPDATE_URL = V1_DATASET_URL + "/documents/metadata";

    String V1_METADATA_LIST_URL = V1_METADATA_CREATE_URL;

    String V1_TEXT_EMBEDDING_LIST_URL = V1_URL + "/workspaces/current/models/model-types/text-embedding";

    String V1_FILES_UPLOAD = V1_URL + "/files/upload";

    String V1_INFO = V1_URL + "/info";

    String V1_META = V1_URL + "/meta";

    String V1_APPS_ANNOTATIONS = V1_URL + "/apps/annotations";

    String V1_APPS_ANNOTATIONS_REPLY = V1_URL + "/apps/annotation-reply";
}
