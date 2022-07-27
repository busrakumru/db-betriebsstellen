import { Component } from '@angular/core';
import { Betriebsstelle } from './interface/betriebsstelle';
import { RequestsService } from './services/requests.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  betriebsstellen?: Betriebsstelle[];
  searchTerm: string = '';
  showBs?: boolean;

  constructor(private requestsService: RequestsService) { }

  ngOnInit(): void {

    this.requestsService.getBetriebsstellen().subscribe((data: Betriebsstelle[]) => {
      this.betriebsstellen = data;
    });

  }

  onEnter() {
    this.showBs = true;
  }

  handleClear(){
    this.searchTerm = '';
    this.showBs = false;
  }
}