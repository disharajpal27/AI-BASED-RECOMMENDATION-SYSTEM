package Recom;
import java.util.List;

public class MovieRecommendationApp {

	

	    public static void main(String[] args) {
	        try {
	            String dataFilePath = "movie_ratings.csv";
	            DataModel model = MovieDataModel.loadData(dataFilePath);
	            long userID = 1; // Example user

	            System.out.println("User-Based Movie Recommendations:");
	            List<RecommendedItem> userRecommendations = UserBasedMovieRecommender.recommendMovies(model, userID, 5);
	            for (RecommendedItem recommendation : userRecommendations) {
	                System.out.println("Movie ID: " + recommendation.getItemID() + " | Score: " + recommendation.getValue());
	            }

	            System.out.println("\nItem-Based Movie Recommendations:");
	            List<RecommendedItem> itemRecommendations = ItemBasedMovieRecommender.recommendMovies(model, userID, 5);
	            for (RecommendedItem recommendation : itemRecommendations) {
	                System.out.println("Movie ID: " + recommendation.getItemID() + " | Score: " + recommendation.getValue());
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
