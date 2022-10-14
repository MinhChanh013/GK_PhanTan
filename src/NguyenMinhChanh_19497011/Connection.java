package NguyenMinhChanh_19497011;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;

public class Connection {

	public static MongoClient Connection() {
		MongoClient mongo_client = new MongoClient("localhost", 27017);
		MongoCredential credential = MongoCredential.createCredential("Chanh013", "eampledb", "Chanh013".toCharArray());
		return mongo_client;
	}
}
