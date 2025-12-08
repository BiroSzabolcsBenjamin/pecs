import { Component, inject, OnInit, signal } from '@angular/core';

import { Place } from '../place.model';
import { PlacesComponent } from '../places.component';
import { PlacesContainerComponent } from '../places-container/places-container.component';
import { HttpClient } from '@angular/common/http';
import { catchError, map, throwError } from 'rxjs';

@Component({
  selector: 'app-available-places',
  standalone: true,
  templateUrl: './available-places.component.html',
  styleUrl: './available-places.component.css',
  imports: [PlacesComponent, PlacesContainerComponent],
})
export class AvailablePlacesComponent implements OnInit {
  places = signal<Place[] | undefined>(undefined);
  isLoading = signal(false);
  error = signal('');
  private httpClient = inject(HttpClient);


  ngOnInit():void {
    this.isLoading.set(true);
    this.httpClient
    .get<{places: Place[]}>('http://localhost:3000/places')
    .pipe(
      map((resData)=> resData.places),
      catchError((error) => throwError(() => new Error()))
    )
    .subscribe({
        next: (places)=> {
          console.log(places);
          this.places.set(places);
          this.isLoading.set(false);
        },
        error: (error)=>  {
          console.log(error());
          this.error.set('Something went wrong!');
          }
    })
  }

  onSelectPlace(selectedPlace:Place){
    this.httpClient.put('http://localhost:3000/user-places', {
      placeId: selectedPlace.id
    }).subscribe({
      next: (res) => console.log(res)
    });
  }
}
