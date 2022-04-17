import { Component, OnInit } from '@angular/core';
import { Character } from 'src/app/models/character';
import { CharacterService } from 'src/app/services/character.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  ngOnInit(): void {

  }


  character = {} as Character;

  charactersStar: Character[] = []

  constructor(private characterServices: CharacterService) { }


  minhaFunca() {
    alert(this.character.name)
  }

  getCharacters() {
    this.characterServices.getCharacters()  
      .subscribe((characters: Character[]) => {
        console.log(characters)
      })
  }

  searchCharacter(character:Character) {
    this.characterServices.getCharacterByName(this.character.name)
      .subscribe(() => {
          this.charactersStar.forEach(e => console.log(e))
      })
  }


}
