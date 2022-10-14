package NguyenMinhChanh_19497011;

import java.util.Iterator;

import static com.mongodb.client.model.Filters.*;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;

public class ServiceImpl implements Service {

	@Override
	public void createCollection(MongoDatabase database, String nameCollection) {
		// TODO Auto-generated method stub
		database.createCollection(nameCollection);
		System.out.println("Tao collection thanh cong");
	}

	@Override
	public void insertDocument(MongoDatabase database, String nameCollection, Document document) {
		// TODO Auto-generated method stub
		database.getCollection(nameCollection).insertOne(document);
		System.out.println("Insert document thanh cong");
	}

	@Override
	public void filterCollection(MongoDatabase database, String nameCollection) {
		MongoCollection<Document> collection = database.getCollection(nameCollection);

		// TODO Auto-generated method stub
		FindIterable<Document> iterDoc = collection.find();
		Iterator<Document> it = iterDoc.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	@Override
	public void filterMin200(MongoDatabase database, String nameCollection) {
		MongoCollection<Document> collection = database.getCollection(nameCollection);
		// TODO Auto-generated method stub
		FindIterable<Document> iterDocSach = collection.find(Filters.gte("Gia", 100));
		Iterator<Document> sach100 = iterDocSach.iterator();
		while (sach100.hasNext()) {
			System.out.println("Sach lon hon 100: " + sach100.next());
		}
	}

	@Override
	public void deleteCollection(MongoDatabase database, String nameCollection) {
		// TODO Auto-generated method stub
		MongoCollection<Document> collection = database.getCollection(nameCollection);
		collection.drop();
		System.out.println("Da xoa thanh cong");
	}

	@Override
	public void deleteOneDocument(MongoDatabase database, String nameCollection) {
		// TODO Auto-generated method stub
		MongoCollection<Document> collection = database.getCollection(nameCollection);
		Bson query = in("TenSach", "Phan Tan");
		try {
			DeleteResult result = collection.deleteOne(query);
			System.out.println("Deleted document count: " + result.getDeletedCount());
		} catch (MongoException me) {
			System.err.println("Unable to delete due to an error: " + me);
		}
	}

	@Override
	public void deleteManyDocument(MongoDatabase database, String nameCollection) {
		MongoCollection<Document> collection = database.getCollection(nameCollection);
		Bson query = gte("Gia", 100);
		try {
			DeleteResult result = collection.deleteMany(query);
			System.out.println("Deleted document count: " + result.getDeletedCount());
		} catch (MongoException me) {
			System.err.println("Unable to delete due to an error: " + me);
		}
	}

	@Override
	public void updateOneDocument(MongoDatabase database, String nameCollection) {
		// TODO Auto-generated method stub
		MongoCollection<Document> collection = database.getCollection(nameCollection);
		collection.updateOne(new Document("TenSach", "PhanTan"),
				new Document("$set", new Document("MaSach", new ObjectId()).append("TenSach", "Phan Tan da sua")
						.append("NXB", "IUH").append("SoTrang", 200).append("Gia", 200)));
	}

	@Override
	public void updateManyDocument(MongoDatabase database, String nameCollection) {
		// TODO Auto-generated method stub
		MongoCollection<Document> collection = database.getCollection(nameCollection);
		collection.updateMany(new Document("TenSach", "Phan Tan"),
				new Document("$set", new Document("MaSach", new ObjectId()).append("TenSach", "Phan Tan sua nhieu")
						.append("NXB", "IUH").append("SoTrang", 200).append("Gia", 200)));
	}
}
