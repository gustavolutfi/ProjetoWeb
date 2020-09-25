package testMongoDB;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Simples {



            MongoClient mongoClient = new MongoClient("localhost",27017 );


                MongoDatabase mongoDatabase = mongoClient.getDatabase("loja");
            //System.out.println("Connect to database successfully");

            //System.out.println(mongoClient.getDatabase("mycol").listCollectionNames());
            //mongoDatabase.getCollection("produtosDois").drop();

            MongoCollection<Document> documentMongoCollection = mongoDatabase.getCollection("produtos");
            Document document = (Document) documentMongoCollection.find().first();
           // System.out.println(document);

            //System.out.println(mongoDatabase.getCollection("produtos").getCodecRegistry());
    //

}






