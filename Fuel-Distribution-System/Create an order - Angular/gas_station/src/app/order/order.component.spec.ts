import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-name-editor',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class NameEditorComponent {
  name = new FormControl('');
}