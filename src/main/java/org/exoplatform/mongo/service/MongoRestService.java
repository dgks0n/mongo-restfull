/*
 * Copyright (C) 2003-2013 eXo Platform SAS.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.exoplatform.mongo.service;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import org.exoplatform.mongo.entity.request.Collection;
import org.exoplatform.mongo.entity.request.Database;
import org.exoplatform.mongo.entity.request.Document;
import org.exoplatform.mongo.entity.request.Index;

import com.sun.jersey.multipart.FormDataMultiPart;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @since Jul 13, 2013
 * @version 
 * 
 * @tag 
 */
public interface MongoRestService {

	// POST /databases
    public Response createDatabase(Database database, @Context HttpHeaders headers, @Context UriInfo uriInfo,
            @Context SecurityContext securityContext);

    // GET /databases/<dbName>
    public Response findDatabase(@PathParam("dbName") String dbName,
            @QueryParam("collDetails") @DefaultValue("false") boolean collDetails, @Context HttpHeaders headers,
            @Context UriInfo uriInfo, @Context SecurityContext securityContext);

    // PUT /databases/<dbName>
    public Response updateDatabase(Database database, @PathParam("dbName") String dbName, @Context HttpHeaders headers,
            @Context UriInfo uriInfo, @Context SecurityContext securityContext);

    // DELETE /databases/<dbName>
    public Response deleteDatabase(@PathParam("dbName") String dbName, @Context HttpHeaders headers,
            @Context UriInfo uriInfo, @Context SecurityContext securityContext);

    // GET /databases
    public Response findDatabases(@QueryParam("collDetails") @DefaultValue("false") boolean collDetails,
            @Context HttpHeaders headers, @Context UriInfo uriInfo, @Context SecurityContext securityContext);

    // DELETE /databases
    public Response deleteDatabases(@Context HttpHeaders headers, @Context UriInfo uriInfo,
            @Context SecurityContext securityContext);

    // POST /databases/<dbName>/collections
    public Response createCollection(@PathParam("dbName") String dbName, Collection collection,
            @Context HttpHeaders headers, @Context UriInfo uriInfo, @Context SecurityContext securityContext);

    // GET /databases/<dbName>/collections/<collName>
    public Response findCollection(@PathParam("dbName") String dbName, @PathParam("collName") String collName,
            @Context HttpHeaders headers, @Context UriInfo uriInfo, @Context SecurityContext securityContext);

    // PUT /databases/<dbName>/collections/<collName>
    public Response updateCollection(@PathParam("dbName") String dbName, @PathParam("collName") String collName,
            Collection collection, @Context HttpHeaders headers, @Context UriInfo uriInfo,
            @Context SecurityContext securityContext);

    // DELETE /databases/<dbName>/collections/<collName>
    public Response deleteCollection(@PathParam("dbName") String dbName, @PathParam("collName") String collName,
            @Context HttpHeaders headers, @Context UriInfo uriInfo, @Context SecurityContext securityContext);

    // GET /databases/<dbName>/collections
    public Response findCollections(@PathParam("dbName") String dbName, @Context HttpHeaders headers,
            @Context UriInfo uriInfo, @Context SecurityContext securityContext);

    // DELETE /databases/<dbName>/collections
    public Response deleteCollections(@PathParam("dbName") String dbName, @Context HttpHeaders headers,
            @Context UriInfo uriInfo, @Context SecurityContext securityContext);

    // POST /databases/<dbName>/collections/<collName>/indexes
    public Response createIndex(@PathParam("dbName") String dbName, @PathParam("collName") String collName,
            Index index, @Context HttpHeaders headers, @Context UriInfo uriInfo,
            @Context SecurityContext securityContext);

    // GET /databases/<dbName>/collections/<collName>/indexes/<index>
    public Response findIndex(@PathParam("dbName") String dbName, @PathParam("collName") String collName,
            @PathParam("index") String index, @Context HttpHeaders headers, @Context UriInfo uriInfo,
            @Context SecurityContext securityContext);

    // DELETE /databases/<dbName>/collections/<collName>/indexes/<index>
    public Response deleteIndex(@PathParam("dbName") String dbName, @PathParam("collName") String collName,
            @PathParam("index") String index, @Context HttpHeaders headers, @Context UriInfo uriInfo,
            @Context SecurityContext securityContext);

    // GET /databases/<dbName>/collections/<collName>/indexes
    public Response findIndexes(@PathParam("dbName") String dbName, @PathParam("collName") String collName,
            @Context HttpHeaders headers, @Context UriInfo uriInfo, @Context SecurityContext securityContext);

    // DELETE /databases/<dbName>/collections/<collName>/indexes
    public Response deleteIndexes(@PathParam("dbName") String dbName, @PathParam("collName") String collName,
            @Context HttpHeaders headers, @Context UriInfo uriInfo, @Context SecurityContext securityContext);

    // POST /databases/<dbName>/collections/<collName>/documents
    public Response createDocument(@PathParam("dbName") String dbName, @PathParam("collName") String collName,
            Document document, @Context HttpHeaders headers, @Context UriInfo uriInfo,
            @Context SecurityContext securityContext);

    // GET /databases/<dbName>/collections/<collName>/documents/<docId>
    public Response findDocument(@PathParam("dbName") String dbName, @PathParam("collName") String collName,
            @PathParam("docId") String docId, @Context HttpHeaders headers, @Context UriInfo uriInfo,
            @Context SecurityContext securityContext);

    // PUT /databases/<dbName>/collections/<collName>/documents/<docId>
    public Response updateDocument(@PathParam("dbName") String dbName, @PathParam("collName") String collName,
            @PathParam("docId") String docId, Document document, @Context HttpHeaders headers,
            @Context UriInfo uriInfo, @Context SecurityContext securityContext);

    // DELETE /databases/<dbName>/collections/<collName>/documents/<docId>
    public Response deleteDocument(@PathParam("dbName") String dbName, @PathParam("collName") String collName,
            @PathParam("docId") String docId, @Context HttpHeaders headers, @Context UriInfo uriInfo,
            @Context SecurityContext securityContext);

    // GET /databases/<dbName>/collections/<collName>/documents
    public Response findDocuments(@PathParam("dbName") String dbName, @PathParam("collName") String collName,
            @Context HttpHeaders headers, @Context UriInfo uriInfo, @Context SecurityContext securityContext);

    // DELETE /databases/<dbName>/collections/<collName>/documents
    public Response deleteDocuments(@PathParam("dbName") String dbName, @PathParam("collName") String collName,
            @Context HttpHeaders headers, @Context UriInfo uriInfo, @Context SecurityContext securityContext);

    // POST /databases/<dbName>/collections/<collName>/binaries
    public Response createBinaryDocument(@PathParam("dbName") String dbName, @PathParam("collName") String collName,
            FormDataMultiPart document, @Context HttpHeaders headers, @Context UriInfo uriInfo,
            @Context SecurityContext securityContext);

    // GET /ping
    public Response ping(@Context HttpHeaders headers, @Context UriInfo uriInfo,
            @Context SecurityContext securityContext);

    // GET /shutdown
    public Response shutdown(@Context HttpHeaders headers, @Context UriInfo uriInfo,
            @Context SecurityContext securityContext);
}
