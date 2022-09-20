import java.util.ArrayList;
import java.util.List;

public class CameraStore {
    List<Camera> cameras;

    public CameraStore(List<Camera> cameras) {
        this.cameras = cameras;
    }


    public Camera suggestCameraByMegapixel() {
        if(cameras.size()==0) throw new NotExistingCameraException();
        Camera maxMegaPixelCamera = cameras.get(0);
        for (Camera camera : cameras) {
            if(maxMegaPixelCamera.getMegaPixels() < camera.getMegaPixels()){
                maxMegaPixelCamera = camera;
            }
        }
        return maxMegaPixelCamera;
    }

    public Camera suggestCameraByMegapixelAndBrand(Brand brand) {
        if(cameras.size()==0) throw new NotExistingCameraException();
        List<Camera> brandedCamera = new ArrayList<>();

        for(Camera camera : cameras){
            if (camera.getBrand().equals(brand)){
                brandedCamera.add(camera);
            }
        }
        if(brandedCamera.size() == 0) {
            throw new NotExistingCameraException();
        }
        Camera maxMegaPixelCamera = brandedCamera.get(0);
        for (Camera camera : brandedCamera) {
            if(maxMegaPixelCamera.getMegaPixels() < camera.getMegaPixels()){
                maxMegaPixelCamera = camera;
            }
        }
        return maxMegaPixelCamera;

    }
}
