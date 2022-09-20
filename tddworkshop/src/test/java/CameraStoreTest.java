import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class CameraStoreTest {
    List<Camera> cameras;
    CameraStore cameraStore;

    @Test
    void suggestCameraByMegapixelThrowExceptionIfEmptyShop(){
        cameras = new ArrayList<Camera>();
        cameraStore = new CameraStore(cameras);
        assertThrows(NotExistingCameraException.class, () -> cameraStore.suggestCameraByMegapixel());
    }

    @Test
    void suggestCameraByMegapixelReturnsMaxResCamera(){
        Camera expected = new Camera(Brand.SONY,"Sony a1", 6000, 50);
        cameras = new ArrayList<Camera>(){{
            add(expected);
            add(new Camera(Brand.CANON,"Canon r3", 4000, 20));
        }};
        cameraStore = new CameraStore(cameras);
        assertEquals(expected,cameraStore.suggestCameraByMegapixel());
    }

    @Test
    void suggestCameraByMegapixelAndBrandReturnsMaxResCamera(){
        Camera expected = new Camera(Brand.CANON,"Canon r5", 4000, 40);
                cameras = new ArrayList<>(){{
            add(new Camera(Brand.CANON,"Canon r3", 4000, 20));
            add(expected);
            add(new Camera(Brand.SONY,"Sony a1", 6000, 50));
        }};
        cameraStore = new CameraStore(cameras);
        assertEquals(expected,cameraStore.suggestCameraByMegapixelAndBrand(Brand.CANON));
    }

    @Test
    void suggestCameraByMegapixelAndBrandThrowExceptionIfEmptyShop(){
        cameras = new ArrayList<Camera>();
        cameraStore = new CameraStore(cameras);
        assertThrows(NotExistingCameraException.class, () -> cameraStore.suggestCameraByMegapixelAndBrand(Brand.CANON));
    }

    @Test
    void suggestCameraByMegapixelAndBrandThrowExceptionIfNoCameraFromBrand(){
        cameras = new ArrayList<>(){{
            add(new Camera(Brand.CANON,"Canon r3", 4000, 20));
            add(new Camera(Brand.SONY,"Sony a1", 6000, 50));
        }};
        cameraStore = new CameraStore(cameras);
        assertThrows(NotExistingCameraException.class, () -> cameraStore.suggestCameraByMegapixelAndBrand(Brand.NIKON));
    }
}
