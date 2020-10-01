public class Radio {
    int freq;
    String mod;

    public Radio(int freq, String mod){
        this.freq = freq;
        this.mod = mod;
    }
    public void setRadio(int freq, String mod) {
        this.freq = freq;
        this.mod = mod;
    }
    public String getRadio() {
        return Integer.toString(this.freq) + " " + this.mod;
    }

    public String setRadioStatus(String status) {
        return status;
    }
}
