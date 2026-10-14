package toros;

public class Silah {
    private final String silahAdi;
    private final int hasar;
    private int dayaniklilik;

    public Silah(String silahAdi, int hasar) {
        if (silahAdi == null || silahAdi.trim().isEmpty()) {
            throw new IllegalArgumentException("Silah adı boş olamaz.");
        }
        if (hasar < 1 || hasar > 100) {
            throw new IllegalArgumentException("Hasar 1 ile 100 arasında olmalıdır.");
        }
        this.silahAdi = silahAdi;
        this.hasar = hasar;
        this.dayaniklilik = 100;
    }

    public int kullan() {
        if (dayaniklilik <= 0) {
            throw new IllegalStateException("Silah kırık");
        }
        dayaniklilik -= 10;
        if (dayaniklilik < 0) {
            dayaniklilik = 0;
        }
        return hasar;
    }

    public void tamirEt() {
        this.dayaniklilik = 100;
    }

    public String bilgiMetni() {
        return silahAdi + " (hasar " + hasar + ", dayanıklılık " + dayaniklilik + ")";
    }

    public String getSilahAdi() { return silahAdi; }
    public int getHasar() { return hasar; }
    public int getDayaniklilik() { return dayaniklilik; }
}