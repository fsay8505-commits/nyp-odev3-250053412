package toros;

public class Lonca {
    private final String ad;
    private final int kurulusYili;
    private String duyuru;

    public Lonca(String ad, int kurulusYili, String duyuru) {
        if (ad == null || ad.length() < 3 || ad.length() > 25) {
            throw new IllegalArgumentException("Lonca adı 3-25 karakter olmalıdır.");
        }
        if (kurulusYili <= 0) {
            throw new IllegalArgumentException("Kuruluş yılı pozitif olmalıdır.");
        }
        this.ad = ad;
        this.kurulusYili = kurulusYili;
        setDuyuru(duyuru);
    }

    public void setDuyuru(String yeniDuyuru) {
        if (yeniDuyuru == null || yeniDuyuru.trim().isEmpty() || yeniDuyuru.length() > 100) {
            throw new IllegalArgumentException("Duyuru boş olamaz ve en fazla 100 karakter olmalıdır.");
        }
        this.duyuru = yeniDuyuru;
    }

    public String getAd() {
        return ad;
    }

    public int getKurulusYili() {
        return kurulusYili;
    }

    public String getDuyuru() {
        return duyuru;
    }

    public String bilgiMetni() {
        return ad + " (kuruluş " + kurulusYili + ") - Duyuru: " + duyuru;
    }
}