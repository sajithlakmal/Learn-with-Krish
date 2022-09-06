import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'gas_station';
  loginForm = new FormGroup({
    octane: new FormControl(),
    litter: new FormControl(),
  })

  constructor(private http: HttpClient) {

  }
  success = "success"
   loginuser() {
    console.warn(this.loginForm.value);
    let body = new HttpParams();

    body = body.set('litter', this.loginForm.value.litter ).set('octane', this.loginForm.value.octane );
    
    const header = new HttpHeaders({ 'Content-Type': 'application/json'});
    this.http.post("http://localhost:8082/publish", body).subscribe((res) => {
      console.log(res);
      if(res=="OK"){
        window.alert("Message send!")
      }
      else{
        window.alert("Not send!")
      }
    });

  }

}
