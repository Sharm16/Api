package com.qa;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.BooksRequestInitializer;
import com.google.api.services.books.Books.Volumes.List;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volumes;
import com.qa.constants.ClientCredentials;
import java.text.NumberFormat;

public class BookSearch {

	private static final String APPLICATION_NAME = "QA-WebGame";

	private static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance();

	private static String queryGoogleBooks(JsonFactory jsonFactory, String query) throws Exception {
		
		String bookStr = "";
		
		// Set up Books client.
		final Books books = new Books.Builder(GoogleNetHttpTransport.newTrustedTransport(), jsonFactory, null)
				.setApplicationName(APPLICATION_NAME)
				.setGoogleClientRequestInitializer(new BooksRequestInitializer(ClientCredentials.getApiKey())).build();

		List volumesList = books.volumes().list(query);
		// Execute the query.
		Volumes volumes = volumesList.execute();
		if (volumes.getTotalItems() == 0 || volumes.getItems() == null) {
			bookStr=bookStr+"No matches found."+"\n";
			return bookStr;
		}

		// Output results.
		for (Volume volume : volumes.getItems()) {
			
				
			Volume.VolumeInfo volumeInfo = volume.getVolumeInfo();
			Volume.SaleInfo saleInfo = volume.getSaleInfo();

			bookStr=bookStr+"\n \n ";
			// Title.
			bookStr=bookStr+"Title: " + volumeInfo.getTitle();
			// Author(s).
			java.util.List<String> authors = volumeInfo.getAuthors();
			if (authors != null && !authors.isEmpty()) {
				bookStr=bookStr+"Author(s): ";
				for (int i = 0; i < authors.size(); ++i) {
					bookStr=bookStr+authors.get(i);
					if (i < authors.size() - 1) {
						bookStr=bookStr+", ";
					}
				}
				bookStr=bookStr+"\n";
			}
			// Description (if any).
			if (volumeInfo.getDescription() != null && volumeInfo.getDescription().length() > 0) {
				bookStr=bookStr+"Description: " + volumeInfo.getDescription();
			}
			// Ratings (if any).
			if (volumeInfo.getRatingsCount() != null && volumeInfo.getRatingsCount() > 0) {
				int fullRating = (int) Math.round(volumeInfo.getAverageRating().doubleValue());
				bookStr=bookStr+"User Rating: ";
				for (int i = 0; i < fullRating; ++i) {
					bookStr=bookStr+"*";
				}
				bookStr=bookStr+" (" + volumeInfo.getRatingsCount() + " rating(s))";
			}
			// Price (if any).
			if (saleInfo != null && "FOR_SALE".equals(saleInfo.getSaleability())) {
				double save = saleInfo.getListPrice().getAmount() - saleInfo.getRetailPrice().getAmount();
				if (save > 0.0) {
					bookStr=bookStr+"List: " + CURRENCY_FORMATTER.format(saleInfo.getListPrice().getAmount()) + "  ";
				}
				bookStr=bookStr+
						"Google eBooks Price: " + CURRENCY_FORMATTER.format(saleInfo.getRetailPrice().getAmount());

				bookStr=bookStr+"\n";
			}
			// Access status.
			String accessViewStatus = volume.getAccessInfo().getAccessViewStatus();
			String message = "Additional information about this book is available from Google at:";
			if ("FULL_PUBLIC_DOMAIN".equals(accessViewStatus)) {
				message = "This public domain book is available for free from Google at:";
			} else if ("SAMPLE".equals(accessViewStatus)) {
				message = "A preview of this book is available from Google at:";
			}
			bookStr=bookStr+message;
			// Link to Google eBooks.
			bookStr=bookStr+volumeInfo.getInfoLink();
		}
		return bookStr;
	}

	public static String search(String bookName) throws Exception {
		JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
		//System.out.println(queryGoogleBooks(jsonFactory, bookName));
		return queryGoogleBooks(jsonFactory, bookName);

	}
}
