package toros;

public class Suikatci extends Karakter {
    private boolean gizli;

    public Suikatci(String ad, Lonca lonca) {
        super(ad, lonca);
        this.gizli = false;
    }

    public void gizlen() {
        hayattaOldugunuDogrula();
        kayitYaz("gölgelere karıştı");
        this.gizli = true;
    }

    @Override
    public int saldir() {
        int temelHasar = super.saldir();
        if (gizli) {
            kayitYaz("Gizli saldırı gerçekleştirildi!");
            gizli = false;
            return temelHasar * 2;
        }
        return temelHasar;
    }

    @Override
    public void bilgiGoster() {
        super.bilgiGoster();
        System.out.println("Gizli mi: " + gizli);
    }

    @Override
    public String toString() {
        return "Suikatci[" + getAd() + ", seviye " + getSeviye() + "]";
    }
}