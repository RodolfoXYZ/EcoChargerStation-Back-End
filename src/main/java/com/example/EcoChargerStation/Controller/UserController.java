package com.example.EcoChargerStation.Controller;

import com.example.EcoChargerStation.Dtos.CreateNewSupplierDTO;
import com.example.EcoChargerStation.Dtos.ErrorBody;
import com.example.EcoChargerStation.Dtos.LoginUserDTO;
import com.example.EcoChargerStation.Dtos.CreateNewClientDTO;
import com.example.EcoChargerStation.Exceptions.UserExceptions.AccountHasBeRegisteredException;
import com.example.EcoChargerStation.Exceptions.UserExceptions.IncorrectDataException;
import com.example.EcoChargerStation.Exceptions.UserExceptions.UserNotFoundException;
import com.example.EcoChargerStation.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginUserDTO login){
        try{
            return ResponseEntity.ok(userService.login(login.email(), login.password()));
        }
        catch(UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorBody(HttpStatus.BAD_REQUEST.name(), e.getMessage()));
        }
    }

    @DeleteMapping("client/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id){
        try{
            userService.DeleteWithClientId(id);
            return ResponseEntity.ok().body(null);
        }
        catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(new ErrorBody(HttpStatus.BAD_REQUEST.name(), e.getMessage()));
        }
    }

    @DeleteMapping("supplier/{id}")
    public ResponseEntity deleteSupplier(@PathVariable Long id){
        try{
            userService.DeleteWithSupplierId(id);
            return ResponseEntity.ok().body(null);
        }
        catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(new ErrorBody(HttpStatus.BAD_REQUEST.name(), e.getMessage()));
        }
    }

    @PostMapping("/createclient")
    public ResponseEntity createClient(@RequestBody CreateNewClientDTO login){
        try{
            userService.RegisterNewUser(login.name(), login.password(), login.email(),login.phone(), login.userName(),login.cpf());
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        }
        catch(AccountHasBeRegisteredException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ErrorBody(HttpStatus.BAD_REQUEST.name(), e.getMessage()));
        } catch (IncorrectDataException e) {
            return ResponseEntity.badRequest().body(new ErrorBody(HttpStatus.BAD_REQUEST.toString(), e.getMessage()));
        }
    }
    @PostMapping("/createsupplier")
    public ResponseEntity createSupplier(@RequestBody CreateNewSupplierDTO register){
        try{
            userService.RegisterNewSupplier(register.cnpj(), register.userName(), register.name(), register.password(), register.email(), register.phone());
            return ResponseEntity.ok().body(null);
        }
        catch(AccountHasBeRegisteredException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ErrorBody(HttpStatus.BAD_REQUEST.name(), e.getMessage()));
        } catch (IncorrectDataException e) {
            return ResponseEntity.badRequest().body(new ErrorBody(HttpStatus.BAD_REQUEST.toString(), e.getMessage()));
        }
    }

}
