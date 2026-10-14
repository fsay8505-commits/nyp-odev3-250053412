package toros;

public class Main {
    public static void main(String[] args) {
        int kDegeri = 12;

        Lonca kartalLoncase = new Lonca("Kartal Loncası", 1071, "Cuma akşamı kale kuşatması!");
        Lonca yildizLoncase = new Lonca("Yıldız Loncası", 1453, "Haftaya büyük turnuva var!");

        int savasciZirhi = kDegeri % 31;
        Savasci savasciKarakter = new Savasci("DemirSavasci", kartalLoncase, savasciZirhi);
        Buyucu buyucuKarakter = new Buyucu("AkBuyucu", kartalLoncase);
        Okcu okcuKarakter = new Okcu("KeskinOkcu", yildizLoncase);

        int kilicHasari = (kDegeri < 10) ? 10 : kDegeri;
        Silah savasciSilahi = new Silah("Kılıç", kilicHasari);
        Silah okcuSilahi = new Silah("Yay", 12);

        savasciKarakter.silahKusan(savasciSilahi);
        okcuKarakter.silahKusan(okcuSilahi);

        System.out.println("Başlangıç Bilgileri");
        savasciKarakter.bilgiGoster();
        buyucuKarakter.bilgiGoster();
        okcuKarakter.bilgiGoster();

        System.out.println("Savaşçı Saldırıları");
        for (int i = 1; i <= 3; i++) {
            int vurulanHasar = savasciKarakter.saldir();
            System.out.println(i + ". Saldırı Hasarı: " + vurulanHasar + ", Silah Dayanıklılığı: " + savasciSilahi.getDayaniklilik());
        }

        System.out.println("Hasar Karşılaştırması (Zırh Etkisi)");
        savasciKarakter.hasarAl(40);
        buyucuKarakter.hasarAl(40);
        System.out.println("Savaşçı Canı (Zırhlı): " + savasciKarakter.getCan());
        System.out.println("Büyücü Canı (Zırhsız): " + buyucuKarakter.getCan());

        System.out.println("Büyü Testleri");
        buyucuKarakter.buyuYap("Ateş Topu", 30);
        buyucuKarakter.buyuYap("Buz Dikeni", 30);
        try {
            buyucuKarakter.buyuYap("Yıldırım", 50);
        } catch (Exception e) {
            System.out.println("Beklenen Hata: " + e.getMessage());
        }

        System.out.println("Okçu Atışları");
        okcuKarakter.atesEt();
        okcuKarakter.atesEt();
        System.out.println("Kalan Ok Sayısı: " + okcuKarakter.getOkSayisi());

        System.out.println("İyileşme ve Seviye Atlatma");
        buyucuKarakter.iyiles(20);
        buyucuKarakter.seviyeAtla();
        buyucuKarakter.bilgiGoster();

        System.out.println("Geçersiz İşlem Testleri");
        try {
            new Karakter("Al", kartalLoncase);
        } catch (Exception e) {
            System.out.println("Hata 1 Yakalandı: " + e.getMessage());
        }

        try {
            savasciKarakter.hasarAl(-5);
        } catch (Exception e) {
            System.out.println("Hata 2 Yakalandı: " + e.getMessage());
        }

        try {
            buyucuKarakter.iyiles(0);
        } catch (Exception e) {
            System.out.println("Hata 3 Yakalandı: " + e.getMessage());
        }

        System.out.println("Lonca Duyuru Değişimi");
        kartalLoncase.setDuyuru("Yeni Duyuru: Kale kapıları açıldı!");
        savasciKarakter.bilgiGoster();
        buyucuKarakter.bilgiGoster();

        System.out.println("toString Testi");
        System.out.println(okcuKarakter);
    }
}