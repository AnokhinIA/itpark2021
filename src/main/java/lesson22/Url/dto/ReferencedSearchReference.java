package lesson22.Url.dto;

import lombok.Data;

@Data
public class ReferencedSearchReference {

    public String title; // 	string 	false 	The title of referenced object.
    public String referenced_id; // 	string 	false 	The id of the referenced object.
    public String referenced_class; //	string 	false 	The type of the referenced object.

    public ReferencedSearchReference() {
    }
}
