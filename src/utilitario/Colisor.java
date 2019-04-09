package utilitario;

public class Colisor {
    public static boolean col(Objeto obj01, Objeto obj02){

        int pxLargObj01 = obj01.getPx() + obj01.getLargura();
        int pxLargObj02 = obj02.getPx() + obj02.getLargura();
        int pyAltObj01 = obj01.getPy() + obj01.getAltura();
        int pyAltObj02 = obj02.getPy() + obj02.getAltura();

        if (!obj01.isAtivo() && !obj02.isAtivo()){
            return false;
        }
        if (obj02.getPx()<=pxLargObj01){
            return true;
        }
        if (obj01.getPx()<=pxLargObj02){
            return true;
        }
        if (obj02.getPy()<=pyAltObj01) {
            return true;
        }
        if (obj01.getPy()<=pyAltObj02){
            return true;
        }
        return false;
    }
}
