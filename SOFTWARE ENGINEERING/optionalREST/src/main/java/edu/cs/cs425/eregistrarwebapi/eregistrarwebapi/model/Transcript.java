package edu.cs.cs425.eregistrarwebapi.eregistrarwebapi.model;

import javax.persistence.*;

@Entity
@Table(name = "transcripts")
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer transcriptId;

    private String degreeTitle;

    public Transcript(String degreeTitle) {
        super();
        this.degreeTitle = degreeTitle;
    }

    public Transcript() {
        super();
    }

    public Integer getTranscriptId() {
        return transcriptId;
    }

    public void setTranscriptId(Integer transcriptId) {
        this.transcriptId = transcriptId;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    @Override
    public String toString() {
        return "Transcript [transcriptId=" + transcriptId + ", degreeTitle=" + degreeTitle + "]";
    }


}
