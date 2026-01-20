import { inject, Injectable, signal } from '@angular/core';

import { Place } from './place.model';
import { HttpClient } from '@angular/common/http';
import { catchError, map, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PlacesService {
  private userPlaces = signal<Place[]>([]);
  private http = inject(HttpClient);

  loadedUserPlaces = this.userPlaces.asReadonly();

  loadAvailablePlaces() {}

  loadUserPlaces() {}

  addPlaceToUserPlaces(place: Place) {}

  removeUserPlace(place: Place) {
    return this.http.delete(`http://localhost:3000/user-places/` + place.id)
      .pipe(
        catchError((error) => {
        this.errorService.showError('Failed to delete selected place.');
        return throwError(() => new Error('Failed to delete selected place.'))
      })
      );
  }

  private fetchPlaces(url: string) {
    return this.http.get<{places:Place[]}>(url)
      .pipe (
        map((res) => res.places)
      )
  }
}
