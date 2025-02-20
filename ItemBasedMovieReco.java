package Recom;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import java.util.List;
public class ItemBasedMovieReco {
	

	
	    public static List<RecommendedItem> recommendMovies(DataModel model, long userID, int numRecommendations) throws Exception {
	        ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);
	        Recommender recommender = new GenericItemBasedRecommender(model, similarity);
	        return recommender.recommend(userID, numRecommendations);
	    }
	}

