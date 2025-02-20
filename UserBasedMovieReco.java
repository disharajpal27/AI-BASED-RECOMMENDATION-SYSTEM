package Recom;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import java.util.List;
public class UserBasedMovieReco {
	


	    public static List<RecommendedItem> recommendMovies(DataModel model, long userID, int numRecommendations) throws Exception {
	        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
	        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
	        Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
	        return recommender.recommend(userID, numRecommendations);
	    }
	}

