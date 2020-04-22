package com.deloit.Covid19track.Services;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.deloit.Covid19track.models.LocationStats;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
public class Covid19DataService {

	private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	
	private List<LocationStats> allStats = new ArrayList<LocationStats>();
	
	public List<LocationStats> getAllStats() {
		return allStats;
	}

	@PostConstruct
	@Scheduled(cron = "* * 1 * * *")
	public void fetchVirusData() throws UnirestException, IOException {
		List<LocationStats> newStats = new ArrayList<LocationStats>();
		HttpResponse<String> response = Unirest.get(VIRUS_DATA_URL).asString();
		StringReader csvBodyReader = new StringReader(response.getBody());
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
		for (CSVRecord record : records) {
			LocationStats locationStats = new LocationStats();
		    locationStats.setState(record.get("Province/State"));
		    locationStats.setCountry(record.get("Country/Region"));
		    int latestCases = Integer.parseInt(record.get(record.size()-1));
		    int preDayCases = Integer.parseInt(record.get(record.size()-2));
		    locationStats.setLatestTotalCases(latestCases);
		    locationStats.setDiffFromPreDay(latestCases - preDayCases);
		    newStats.add(locationStats);
		}
		this.allStats = newStats;
		 
	}
}
