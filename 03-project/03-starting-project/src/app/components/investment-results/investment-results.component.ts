import { Component, Input } from '@angular/core';

import { DecimalPipe } from '@angular/common';

@Component({
  selector: 'app-investment-results',
  imports: [DecimalPipe],
  templateUrl: './investment-results.component.html',
  styleUrl: './investment-results.component.css',
})
export class InvestmentResultsComponent {
  @Input() results?: any[] | null | undefined;
}
