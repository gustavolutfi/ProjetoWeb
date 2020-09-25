package testMongoDB;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class BancoMDB {
    private MongoDatabase mongoDatabase;
    private MongoClient mongoClient;


    public void conectar(){
        try {
            mongoClient = new MongoClient("localhost",27017 );
            //System.out.println("Banco Conectado");

        }catch (Exception e){
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
        }
    }

    public void inserirCollection(String database, String collection){
        mongoDatabase = mongoClient.getDatabase(database);
        mongoDatabase.createCollection(collection);
    }

    public void removerCollection(String database, String collection){
        mongoDatabase = mongoClient.getDatabase(database);
        mongoDatabase.getCollection(collection).drop();
    }

    public void pesquisar(String database, String collection){
        MongoDatabase mongoDatabase = mongoClient.getDatabase(database);
        MongoCollection<Document> documentMongoCollection = mongoDatabase.getCollection(collection);
        Document document = (Document) documentMongoCollection.find().first();
        System.out.println(document);
    }


    public void inserirDoc(String database, String collection, String nome, int idade, int matricula, String profissao){
        mongoDatabase = mongoClient.getDatabase(database);
        MongoCollection<Document> documentMongoCollection = mongoDatabase.getCollection(collection);
        Document produto = new Document("Nome", nome).append("Idade", idade).append("Matricula", matricula).append("Profissao",profissao);
        documentMongoCollection.insertOne(produto);
    }

    public void removeDoc(String database, String collection, String matricula){
        mongoDatabase = mongoClient.getDatabase(database);
        MongoCollection<Document> documentMongoCollection = mongoDatabase.getCollection(collection);
        Document produto = new Document("Latricula", matricula);
        documentMongoCollection.deleteMany(produto);
    }

    public void alterar(){
        mongoDatabase = mongoClient.getDatabase("loja");
        MongoCollection<Document> documentMongoCollection = mongoDatabase.getCollection("produtos");
    }

    }


