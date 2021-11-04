import { Component, OnInit } from '@angular/core';
import { Sleep } from '../models/sleep';
import { SleepTrackerService } from '../services/sleep-tracker.service';

@Component({
  selector: 'app-sleep-tracker',
  templateUrl: './sleep-tracker.component.html',
  styleUrls: ['./sleep-tracker.component.css']
})
export class SleepTrackerComponent implements OnInit {

  sleepTracked: Sleep[] = [];
  selected: Sleep | null = null;
  newSleep: Sleep = new Sleep();
  editSleep: Sleep | null = null;

  constructor(private sleepService: SleepTrackerService) { }

  ngOnInit(): void {
    this.loadSleepTracked();
  }

  loadSleepTracked() {
    this.sleepService.index().subscribe(
      sleepTracked => {
        this.sleepTracked = sleepTracked;
      },
      fail => {
        console.log('SleepTrackerComponent.reloadSleepTracked(): error loading sleep tracked');
      }
    );
  }

  displaySleep(sleep: Sleep): void {
    this.selected = sleep;
  }

  addSleep(sleep: Sleep) {
    this.sleepService.create(sleep).subscribe(
      // (success) = {
      //   this.loadSleepTracked();
      //   this.sleep = new Sleep();
      //   console.log('SleepTracked.addSleep(): new sleep successfully created');
      // },
      (err) => {
        console.error('SleepTracked.addSleep(): error creating new sleep');
        console.error(err);
      }
    );
  }

  setEditSleep(): void {
    this.editSleep = Object.assign({}, this.selected);
  }



  updateSleep(sleep: Sleep, showSleep = true): void {
    this.sleepService.update(sleep).subscribe(
      (updated) => {
        this.loadSleepTracked();
        this.editSleep = null;
        if (showSleep) {
          this.selected = updated;
        }
        this.selected = updated;
      },

      (failure) => {
        console.error('SleepTracked.updateSleep(): error updating new sleep');
        console.error(failure);
      }
    );
  }



  deleteSleep(id: number): void {
    this.sleepService.delete(id).subscribe(
      (success) => {
        this.loadSleepTracked();
      },
      (failure) => {
        console.error('SleepTracked.deleteSleep(): error deleting new sleep');
        console.error(failure);
      }
    );
  }

}
