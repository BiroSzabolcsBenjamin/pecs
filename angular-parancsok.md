# **Frontend**



### ***node module instal***

 	konzol 			--> npm i



### ***project megnyitás***

  	**cd "*mappa neve*"**		--> belépés mappába

  	**ng s -o**  	  	--> ha nincs megnyitva böngészőbe

  	**ng s**     	  	--> ha megvan

&nbsp; 	**kilépés**			--> ctrl + c

### 

### ***generálás***

  	**ng generate s**  		--> service generálás

&nbsp;	**ng generate c**		--> component generálás



 	mappa-neve/fájl-név HA EGY ADOTT MAPPÁBA AKAROD  GENERÁLNI



## **CRUD**

 - create

 - read

 - update

 - delete



# **ternary operator**

 	? true : false (if/else)



spread operator





## ***MAP***

map majdnem forEach



## ***PIPE***

pipe függvény

 	return kimenetével dolgozik tovább



## ***TRIM***

&nbsp;	.trim() --> felesleges szóközöket levágja



## ***TERM***

&nbsp;	term 	--> bemeneti érték



 

## ***event listener***

(használni kívánt event)=""



## ***async pipe***

hero of heroes | async - addig nem létezik míg az async nem küldi vissza



details.component.html

Notice that the housingLocation properties are being accessed with the optional chaining operator ?. This ensures that if the housingLocation value is null or undefined the application doesn't crash.





---



# RÉGI FOR MEGOLDÁS

<div class="heroes-menu">

  <a **\*ngFor="let hero of heroes"**

      routerLink="/detail/{{hero.id}}">

      {{hero.name}}

  </a>

</div>



# ÚJ FOR MEGOLDÁS

<div class="heroes-menu">

    **@for** **(hero of heroes; track $index) {**

        <a routerLink="/detail/{{ hero.id }}">

            {{ hero.name }}

        </a>

    **}**

</div>





# RÉGI IF MEGOLDÁS

<div \\\*ngIf="hero">

  <h2>{{hero.name | uppercase}} Details</h2>

  <div><span>id: </span>{{hero.id}}</div>

  <div>

    <label for="hero-name">Hero name: </label>

    <input id="hero-name" \[(ngModel)]="hero.name" placeholder="Hero name"/>

  </div>

  <button type="button" (click)="goBack()">go back</button>

  <button type="button" (click)="save()">save</button>

</div>





      <app-housing-location

        \*ngFor="let housingLocation of housingLocationList"

        \[housingLocation]="housingLocation"

      ></app-housing-location>





# ÚJ IF MEGOLDÁS

@if (hero) {

<div>

    <h2>{{ hero.name | uppercase }} Details</h2>

    <div>id : {{ hero.id }}</div>

    <div>

        <label for="hero-name">Hero name:</label>

        <input id="hero-name" placeholder="Name" \[(ngModel)]="hero.name">

    </div>

    <button type="button" (click)="save()">Save</button>

    <button type="button" (click)="goBack()">Go Back</button>

</div>





    @for (housingLocation of housingLocationList; track $index){

        <app-housing-location

            \[housingLocation]="housingLocation">

        </app-housing-location>

    }

}



# Régi routerLink

**\[routerLink]=**"\['/details', housingLocation.id]



# Új router link

**routerLink=**"/details/{{housingLocation.id}}"





this.applyForm.value.email ?? ''

This button does not exist yet - you will add it in the next step. In the above code, the FormControls may return null. This code uses the nullish coalescing operator to default to empty string if the value is null.

