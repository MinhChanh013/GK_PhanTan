package NguyenMinhChanh_19497011;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.Scanner;

public class Main {
	static Connection connection;
	static int indexMenu;

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		// TODO Auto-generated method stub
		MongoClient mongo_client = connection.Connection();

		// Create Database
		MongoDatabase database = mongo_client.getDatabase("demoThiGk");
		ServiceImpl serviceImpl = new ServiceImpl();

		do {
			System.out.println("---------------Menu-----------------");
			System.out.println("Nhap 1: Tao collection");
			System.out.println("Nhap 2: Insert document");
			System.out.println("Nhap 3: Doc du lieu trong collection");
			System.out.println("Nhap 4: Doc du lieu trong collection gia hon 100$");
			System.out.println("Nhap 5: Xoa collection");
			System.out.println("Nhap 6: Xoa mot collection co ten sach là phan tan");
			System.out.println("Nhap 7: Xoa nhieu collection gia hon 100$");
			System.out.println("Nhap 8: Cap nhat mot collection");
			System.out.println("Nhap 9: Cap nhat nhieu collection");
			System.out.println("Nhap 0: Exit");
			indexMenu = ip.nextInt();
			switch (indexMenu) {
			case 1:
				// Create Collection
				serviceImpl.createCollection(database, "Sach");
				break;
			case 2:
				// Create Document
				Document sach1 = new Document("MaSach", new ObjectId()).append("TenSach", "Phan Tan")
						.append("NXB", "IUH").append("SoTrang", 200).append("Gia", 200);
				serviceImpl.insertDocument(database, "Sach", sach1);
				break;
			case 3:
				// Filter Collection
				serviceImpl.filterCollection(database, "Sach");
				break;
			case 4:
				// Filter Collection
				serviceImpl.filterMin200(database, "Sach");
				break;
			case 5:
				// Filter Collection
				serviceImpl.deleteCollection(database, "Sach");
				break;
			case 6:
				// Filter Collection
				serviceImpl.deleteOneDocument(database, "Sach");
				break;
			case 7:
				// Filter Collection
				serviceImpl.deleteManyDocument(database, "Sach");
				break;
			case 8:
				// Filter Collection
				serviceImpl.updateOneDocument(database, "Sach");
				break;
			case 9:
				// Filter Collection
				serviceImpl.updateManyDocument(database, "Sach");
				break;
			default:
				System.out.println("Nhap sai!");
				indexMenu = ip.nextInt();
				break;
			}
//			indexMenu = ip.nextInt();
		} while (indexMenu != 0);
	}

}
