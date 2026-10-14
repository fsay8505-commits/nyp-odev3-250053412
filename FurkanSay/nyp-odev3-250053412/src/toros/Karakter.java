package toros;

public class Karakter {
    private final String ad;
    private int seviye;
    private int can;
    private final Lonca lonca;
    private Silah silah;

    public Karakter(String ad, Lonca lonca) {
        if (ad == null || ad.length() < 3 || ad.length() > 15) {
            throw new IllegalArgumentException("Karakter adı 3-15 karakter olmalıdır.");
        }
        if (lonca == null) {
            throw new IllegalArgumentException("Lonca null olamaz.");
        }
        this.ad = ad;
        this.seviye = 1;
        this.can = azamiCan();
        this.lonca = lonca;
        this.silah = null;
    }

    public final int azamiCan() {
        return 100 + (seviye * 10);
    }

    public final boolean hayattaMi() {
        return can > 0;
    }

    protected void hayattaOldugunuDogrula() {
        if (!hayattaMi()) {
            throw new IllegalStateException("Karakter hayatta değil.");
        }
    }

    protected void kayitYaz(String olay) {
        System.out.println("[" + ad + "] " + olay);
    }

    public void hasarAl(int miktar) {
        if (miktar <= 0) {
            throw new IllegalArgumentException("Hasar pozitif olmalı.");
        }
        can -= miktar;
        if (can < 0) {
            can = 0;
        }
    }

    public void iyiles(int miktar) {
        hayattaOldugunuDogrula();
        if (miktar <= 0) {
            throw new IllegalArgumentException("İyileşme miktarı pozitif olmalı.");
        }
        can += miktar;
        int max = azamiCan();
        if (can > max) {
            can = max;
        }
    }

    public void seviyeAtla() {
        hayattaOldugunuDogrula();
        if (seviye >= 50) {
            throw new IllegalStateException("Maksimum seviyeye ulaşıldı.");
        }
        seviye++;
        can = azamiCan();
    }

    public int saldir() {
        hayattaOldugunuDogrula();
        if (silah == null) {
            return seviye;
        }
        return 5 + silah.kullan() + seviye;
    }

    public void silahKusan(Silah yeniSilah) {
        hayattaOldugunuDogrula();
        if (yeniSilah == null) {
            throw new IllegalArgumentException("Silah null olamaz.");
        }
        this.silah = yeniSilah;
    }

    public void bilgiGoster() {
        String silahBilgi = (silah == null) ? "yok" : silah.getSilahAdi();
        System.out.println(ad + " | Seviye " + seviye + " | Can " + can + "/" + azamiCan() + " | Lonca: " + lonca.getAd() + " | Silah: " + silahBilgi);
    }

    public int getCan() {
        return can;
    }

    public int getSeviye() {
        return seviye;
    }

    public String getAd() {
        return ad;
    }

    @Override
    public String toString() {
        return "Karakter[" + ad + ", seviye " + seviye + "]";
    }
}