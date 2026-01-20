import { Component, inject, OnInit, signal } from '@angular/core';

import { PlacesContainerComponent } from '../places-container/places-container.component';
import { PlacesComponent } from '../places.component';
import { Place } from '../place.model';
import { HttpClient } from '@angular/common/http';
import { map, catchError, throwError } from 'rxjs';

@Component({
  selector: 'app-user-places',
  standalone: true,
  templateUrl: './user-places.component.html',
  styleUrl: './user-places.component.css',
  imports: [PlacesContainerComponent, PlacesComponent],
})
export class UserPlacesComponent implements OnInit {
  places = signal<Place[] | undefined>(undefined);
  isLoading = signal(false);
  error = signal('');
  private httpClient = inject(HttpClient);

  private userP


  ngOnInit(): void {
    this.isLoading.set(true);
    this.httpClient
      .get<{ places: Place[] }>('http://localhost:3000/user-places')
      .pipe(
        map((resData) => resData.places),
        catchError((error) => throwError(() => new Error()))
      )
      .subscribe({
        next: (places) => {
          console.log(places);
          this.places.set(places);
          this.isLoading.set(false);
        },
        error: (error) => {
          console.log(error());
          this.error.set('Something went wrong fetching your fav places!');
        },
      });
  }

  onRemovePlace(removePlace: Place){
    this.placesService.removeUserPlace(removePlace).subscribe({
      next: (res) => console.log(res)
    });
  }
}
