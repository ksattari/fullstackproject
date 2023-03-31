import { Component } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Spring Boot - Angular Restaurant Admin';

  constructor(private router: Router){}

  ngOnInit(){
    this.router.routeReuseStrategy.shouldReuseRoute = function(){
      return false;
    };
  
    this.router.events.subscribe((evt) => {
      if (evt instanceof NavigationEnd) {
          this.router.navigated = false;
          window.scrollTo(0, 0);
      }
     });
  }

}
