package it.clefra.web.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

import org.apache.http.annotation.Experimental;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.clefra.persistence.repositories.CredentialsRepository;
import it.clefra.persistence.repositories.UsersRepository;
import it.clefra.spring.security.JwtUtil;
import it.clefra.web.dto.UserDetailDto;

@RepositoryRestController @RequestMapping (VotesController.API_ROOT_URI)	
public class VotesController {

	private static final Logger LOGGER = LoggerFactory.getLogger(VotesController.class);
	public static final String API_ROOT_URI = "/votes";
	public static final String USERID_HEADER_NAME = "UserId";
	public static final String JWT_HEADER_PREFIX = "Bearer";
	public static final Integer JWT_HEADER_LENGTH = 7;

	@Autowired
	private CredentialsRepository credentialRepository;

	@Autowired
	private UsersRepository usersRepository;

	private JwtUtil jwtUtil;

	@RequestMapping(method = RequestMethod.GET)
	@Experimental
	public ResponseEntity<Void> get() {
		LOGGER.debug("Start getting votes");

		try{
			URL url = new URL("http://www.gazzetta.it/calcio/fantanews/voti/serie-a-2015-16/");
			//Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.cervedgroup.com", 8080)); // or whatever your proxy is
			//HttpURLConnection uc = (HttpURLConnection)url.openConnection(proxy);
			HttpURLConnection uc = (HttpURLConnection)url.openConnection();

			uc.connect();

			String line = null;
			StringBuffer tmp = new StringBuffer();
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			boolean flag = false;
			while ((line = in.readLine()) != null) {
				if(line.contains("magicTeamList")){
					flag = true;
				}
				if(flag){
					tmp.append(line);
				}
			}

			Document votesDocument = Jsoup.parse(String.valueOf(tmp));
			Elements elements = votesDocument.getElementsByClass("magicTeamList");
			Elements teamName = votesDocument.getElementsByClass("teamName");
			LOGGER.debug("elements: {}", elements.toString());
			LOGGER.debug("tmp: {}", String.valueOf(tmp));

		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}

		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.OK);
		LOGGER.debug("Request computed. Returning response to Client");
		return response;
	}

}
