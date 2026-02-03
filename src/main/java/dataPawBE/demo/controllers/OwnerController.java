package dataPawBE.demo.controllers;

//Falta importar el OwnerService
import dataPawBE.demo.models.Owner;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/owner")
public class OwnerController {
    @Autowired
    OwnerService ownerService;

    @PostMapping
    public ResponseEntity <Owner> save(@RequestBody Owner data){
      Owner saveResponseAPI = this.ownerService.saveOwner(data);
      return ResponseEntity.status(HttpStatus.OK).body(saveResponseAPI);
    };
}
