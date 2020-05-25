package com.mo.kyung.dps.openapi.application.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.mo.kyung.dps.openapi.application.core.services.ArtistServices;
import com.mo.kyung.dps.openapi.application.data.ArtistDetailValue;
import com.mo.kyung.dps.openapi.application.data.ArtistInfoValue;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(
	name = "Artists")
public class ArtistResource {
	private String id = "";
	private ArtistServices services = ArtistServices.INSTANCE;

	@SuppressWarnings("unused")
	private ArtistResource() {}
	public ArtistResource(
		String id) {
		this.id = id;
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
		public Response getArtist() {
			try {
				ArtistDetailValue details
				= services.get(this.id);
				return Response.ok().entity(details).build();
			} catch (RuntimeException e) {
				return Response.status(400).build();
			}
	}

	@GET
	@Path("info")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSongs() {
		try {
			ArtistInfoValue info
				= services.getInfo(this.id);
			return Response.ok().entity(info).build();
		} catch (RuntimeException e) {
			return Response.status(400).build();
		}
	}
}
