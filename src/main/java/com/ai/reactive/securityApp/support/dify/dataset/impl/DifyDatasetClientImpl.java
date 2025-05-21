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
package com.ai.reactive.securityApp.support.dify.dataset.impl;

import com.ai.reactive.securityApp.model.dify.DifyPageResult;
import com.ai.reactive.securityApp.support.dify.dataset.DifyDataset;
import com.ai.reactive.securityApp.support.dify.dataset.client.DifyDatasetClient;
import com.ai.reactive.securityApp.support.dify.dataset.dto.request.*;
import com.ai.reactive.securityApp.support.dify.dataset.dto.response.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @author j
 * @version 1
 * @since 2025/4/8 14:44
 */
@Slf4j
public class DifyDatasetClientImpl implements DifyDataset {

    private final DifyDatasetClient difyDatasetClient;

    public DifyDatasetClientImpl(DifyDatasetClient difyDatasetClient) {
        this.difyDatasetClient = difyDatasetClient;
    }

    @Override
    public DatasetResponse create(DatasetCreateRequest request) {
        return difyDatasetClient.create(request);
    }

    @Override
    public DifyPageResult<DatasetResponse> page(DatasetPageRequest request) {
        return difyDatasetClient.page(request);
    }

    @Override
    public void delete(String datasetId, String apiKey) {
        difyDatasetClient.delete(datasetId, apiKey);
    }

    @Override
    public DocumentCreateResponse createDocumentByText(DocumentCreateByTextRequest request) {
        return difyDatasetClient.createDocumentByText(request);
    }

    @Override
    public DocumentCreateResponse createDocumentByFile(DocumentCreateByFileRequest request) {
        return difyDatasetClient.createDocumentByFile(request);
    }

    @Override
    public DocumentCreateResponse updateDocumentByText(DocumentUpdateByTextRequest request) {
        return difyDatasetClient.updateDocumentByText(request);
    }

    @Override
    public DocumentCreateResponse updateDocumentByFile(DocumentUpdateByFileRequest request) {
        return difyDatasetClient.updateDocumentByFile(request);
    }

    @Override
    public DifyPageResult<DocumentInfo> pageDocument(DatasetPageDocumentRequest request) {
        return difyDatasetClient.pageDocument(request);
    }

    @Override
    public DocumentIndexingStatusResponse indexingStatus(DocumentIndexingStatusRequest request) {
        return difyDatasetClient.indexingStatus(request);
    }

    @Override
    public DocumentDeleteResponse deleteDocument(String datasetId, String documentId, String apiKey) {
        return difyDatasetClient.deleteDocument(datasetId, documentId, apiKey);
    }

    @Override
    public SegmentResponse createSegment(SegmentCreateRequest request) {
        return difyDatasetClient.createSegment(request);
    }

    @Override
    public SegmentResponse pageSegment(SegmentPageRequest request) {
        return difyDatasetClient.pageSegment(request);
    }

    @Override
    public SegmentDeleteResponse deleteSegment(String datasetId, String documentId, String segmentId, String apiKey) {
        return difyDatasetClient.deleteSegment(datasetId, documentId, segmentId, apiKey);
    }

    @Override
    public SegmentUpdateResponse updateSegment(SegmentUpdateRequest request) {
        return difyDatasetClient.updateSegment(request);
    }

    @Override
    public SegmentChildChunkCreateResponse createSegmentChildChunk(SegmentChildChunkCreateRequest request) {
        return difyDatasetClient.createSegmentChildChunk(request);
    }

    @Override
    public DifyPageResult<SegmentChildChunkResponse> pageSegmentChildChunk(SegmentChildChunkPageRequest request) {
        return difyDatasetClient.pageSegmentChildChunk(request);
    }

    @Override
    public SegmentChildChunkDeleteResponse deleteSegmentChildChunk(SegmentChildChunkDeleteRequest request) {
        return difyDatasetClient.deleteSegmentChildChunk(request);
    }

    @Override
    public SegmentChildChunkUpdateResponse updateSegmentChildChunk(SegmentChildChunkUpdateRequest request) {
        return difyDatasetClient.updateSegmentChildChunk(request);
    }

    @Override
    public UploadFileInfoResponse uploadFileInfo(String datasetId, String documentId, String apiKey) {
        return difyDatasetClient.uploadFileInfo(datasetId, documentId, apiKey);
    }

    @Override
    public RetrieveResponse retrieve(RetrieveRequest request) {
        return difyDatasetClient.retrieve(request);
    }

    @Override
    public MetaDataResponse createMetaData(MetaDataCreateRequest request) {
        return difyDatasetClient.createMetaData(request);
    }

    @Override
    public MetaDataResponse updateMetaData(MetaDataUpdateRequest request) {
        return difyDatasetClient.updateMetaData(request);
    }

    @Override
    public void deleteMetaData(String datasetId, String metadataId, String apiKey) {
        difyDatasetClient.deleteMetaData(datasetId, metadataId, apiKey);
    }

    @Override
    public void actionMetaData(MetaDataActionRequest request) {
        difyDatasetClient.actionMetaData(request);
    }

    @Override
    public void updateDocumentMetaData(DocumentMetaDataUpdateRequest request) {
        difyDatasetClient.updateDocumentMetaData(request);
    }

    @Override
    public MetaDataListResponse listMetaData(String datasetId, String apiKey) {
        return difyDatasetClient.listMetaData(datasetId, apiKey);
    }

    @Override
    public TextEmbeddingListResponse listTextEmbedding(String apiKey) {
        return difyDatasetClient.listTextEmbedding(apiKey);
    }
}
