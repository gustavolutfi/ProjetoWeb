package testMongoDB;

public class Pricipal {
    public static void main(String[] args) {
        BancoMDB bancoMDB = new BancoMDB();
        bancoMDB.conectar();
        bancoMDB.removeDoc("empresa","pessoas","Elder");


    }
}
