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
    username: new FormControl(),
    password: new FormControl(),
  })

  loginuser(){
    console.warn(this.loginForm.value);
 
  }

}
