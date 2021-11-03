export class Sleep {

  id: number;
  day: String;
  sleepDuration: number;
  desiredSleepTime: number;


  constructor(
    id: number = 0,
    day: string = '',
    sleepDuration: number = 0,
    desiredSleepTime: number = 0
  ){
    this.id = id;
    this.day = day;
    this.sleepDuration = sleepDuration;
    this.desiredSleepTime = desiredSleepTime;
  }

}
