import { Component, computed, inject } from '@angular/core';
import { HeaderComponent } from './components/header/header.component';
import { InvestmentResultsComponent } from './components/investment-results/investment-results.component';
import { UserInputComponent } from './components/user-input/user-input.component';
import { InvestmentService } from './investment.service';

@Component({
  selector: 'app-root',
  imports: [
    HeaderComponent,
    InvestmentResultsComponent,
    UserInputComponent,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {

  private investmentService = inject(InvestmentService);

  results = computed(() => this.investmentService.resultData() ?? null);
}
