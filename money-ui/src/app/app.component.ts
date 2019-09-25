import { Component } from '@angular/core';

import { ToastyConfig } from 'ng2-toasty';
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(toastyConfig: ToastyConfig,
              private router: Router){
    toastyConfig.theme = 'bootstrap';
  }

  naoEhTelaDeLogin() {
    return this.router.url !== '/login';
  }
}
