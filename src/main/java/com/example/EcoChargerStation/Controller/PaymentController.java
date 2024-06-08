package com.example.EcoChargerStation.Controller;
import com.example.EcoChargerStation.Dtos.CreatePaymentDTO;
import com.example.EcoChargerStation.Dtos.ErrorBody;
import com.example.EcoChargerStation.Dtos.ReleasePayment;
import com.example.EcoChargerStation.Exceptions.PointExceptions.PointNotFoundException;
import com.example.EcoChargerStation.Exceptions.RechargeExceptions.ItHasBeenPaidException;
import com.example.EcoChargerStation.Exceptions.UserExceptions.UserNotFoundException;
import com.example.EcoChargerStation.Models.Point;
import com.example.EcoChargerStation.Services.PaymentServices;
import com.example.EcoChargerStation.Services.QRcodeServices;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;


@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    QRcodeServices qrcodeServices;
    @Autowired
    PaymentServices paymentServices;

    @GetMapping("/verify")
    public ResponseEntity scanning(@RequestParam Long id){
        try{
            paymentServices.ConfirmPayment(id);
            return ResponseEntity.ok().body(new ReleasePayment("Pagamento Efetuado", "Pagamento efetuado com sucesso"));
        }catch (ItHasBeenPaidException e) {
            return ResponseEntity.badRequest().body(new ErrorBody(HttpStatus.BAD_REQUEST.name(), e.getMessage()));
        }
    }




    @GetMapping("qrcode/{name}")
    public ResponseEntity ImageProvider(@PathVariable String name)  {
        try{
            Path newPath = Paths.get("src/main/java/com/example/EcoChargerStation/pictures/").resolve(name);
            Resource newResource = new UrlResource(newPath.toUri());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // ou MediaType.IMAGE_PNG, etc.
            return ResponseEntity.ok().headers(headers).body(newResource);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(new ErrorBody(HttpStatus.BAD_REQUEST.name(), e.getMessage()));
        }


    }

    @PostMapping("/qrcode")
    public ResponseEntity GeneratePaymentQRCode(@RequestBody CreatePaymentDTO payment){
        try {
            System.out.println(payment.value());
            System.out.println(payment.pointId());
            System.out.println(payment.clientId());
            return ResponseEntity.ok().body(qrcodeServices.GenerateQRCode(payment.clientId(), payment.pointId(), payment.value(), payment.vehicleId()));
        }catch (UserNotFoundException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
        catch (PointNotFoundException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
