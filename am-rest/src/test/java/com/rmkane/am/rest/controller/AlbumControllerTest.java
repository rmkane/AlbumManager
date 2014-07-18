package com.rmkane.am.rest.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.rmkane.am.data.dto.AlbumDto;
import com.rmkane.am.data.dto.ArtistDto;
import com.rmkane.am.rest.controller.AlbumRestURIConstants;

public class AlbumControllerTest {

	public static final String SERVER_URI = "http://localhost:8080/rest";

	public static void main(String args[]) {

		testGetDummyAlbum();
		System.out.println("*****");
		testCreateAlbum();
		System.out.println("*****");
		testGetAlbum();
		System.out.println("*****");
		testGetAllEmployee();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void testGetAllEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		// We can't get List<Employee> because JSON converter doesn't know the
		// type of object in the list and hence convert it to default JSON
		// object type LinkedHashMap
		List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI
				+ AlbumRestURIConstants.GET_ALL_ALBUMS, List.class);
		System.out.println(emps.size());
		for (LinkedHashMap map : emps) {
			LinkedHashMap artistMap = (LinkedHashMap) map.get("artist");

			System.out.println("ID=" + map.get("id") + ",Title="
					+ map.get("title") + ",ReleaseYear="
					+ map.get("releaseYear") + ",ArtistID="
					+ artistMap.get("id") + ",ArtistName="
					+ artistMap.get("name"));
			;
		}
	}

	private static void testCreateAlbum() {
		POST(AlbumRestURIConstants.CREATE_ALBUM,
				create(1L, "Let It Be", 1967, "The Beatles"));
	}

	private static void testGetAlbum() {
		String url = AlbumRestURIConstants.GET_ALBUM.replaceAll("\\{id\\}", "1"); 
		
		System.out.println(url);
		
		GET(url);
	}

	private static void testGetDummyAlbum() {
		GET(AlbumRestURIConstants.DUMMY_ALBUM);
	}

	public static void printAlbumData(AlbumDto album) {
		System.out.println(album);
	}

	private static final void GET(String url) {
		printAlbumData(new RestTemplate().getForObject(SERVER_URI + url,
				AlbumDto.class));
	}

	private static final void POST(String url, AlbumDto album) {
		printAlbumData(new RestTemplate().postForObject(SERVER_URI + url,
				album, AlbumDto.class));
	}

	private static ArtistDto create(long id, String name) {
		ArtistDto artist = new ArtistDto();

		artist.setId(id);
		artist.setName(name);

		return artist;
	}

	private static AlbumDto create(long id, String title, int releaseYear,
			String artistName) {
		AlbumDto album = new AlbumDto();

		album.setId(id);
		album.setTitle(title);
		album.setArtist(create(id, artistName));
		album.setReleaseYear(releaseYear);

		return album;
	}
}
