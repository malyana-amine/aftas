export class Competition {
    id!: number;
    code!: string;
    date!: Date;
    startTime!: any; // Assuming you only need the time as a string, adjust the type accordingly
    endTime!: any; // Assuming you only need the time as a string, adjust the type accordingly
    numberOfParticipant!: number;
    location!: string;
    amount!: number;
}