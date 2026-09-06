package com.pvmarcon.challenge.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_timeslot")
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "beginning_time")
    private Instant beginning;
    @Column(name = "end_time")
    private Instant end;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    public TimeSlot(){
    }

    public TimeSlot(Long id, Instant beginning, Instant end) {
        this.id = id;
        this.beginning = beginning;
        this.end = end;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getBeginning() {
        return beginning;
    }

    public void setBeginning(Instant beginning) {
        this.beginning = beginning;
    }

    public Instant getEnd() {
        return end;
    }

    public void setEnd(Instant end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        TimeSlot timeSlot = (TimeSlot) o;
        return Objects.equals(id, timeSlot.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
