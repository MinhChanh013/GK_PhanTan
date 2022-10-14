package NguyenMinhChanh_19497011;

import org.bson.Document;

import com.mongodb.client.MongoDatabase;

public interface Service {
	public void createCollection(MongoDatabase database, String nameCollection);
	public void insertDocument(MongoDatabase database, String nameCollection, Document document );
	public void filterCollection(MongoDatabase database, String nameCollection);
	public void filterMin200(MongoDatabase database, String nameCollection);
	public void deleteCollection(MongoDatabase database, String nameCollection);
	public void deleteOneDocument(MongoDatabase database, String nameCollection);
	public void deleteManyDocument(MongoDatabase database, String nameCollection);
	public void updateOneDocument(MongoDatabase database, String nameCollection);
	public void updateManyDocument(MongoDatabase database, String nameCollection);
}