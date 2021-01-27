<?php

class Profil_m extends CI_Model
{
    public function getAll($id = null ){
        if($id === null){

            return $this->db->get('profil')->result_array();
        }else{
            return $this->db->get_where('profil', ['id' => $id])->result_array();
        }
    }

    public function create($data){
        
        $this->db->insert('profil', $data);
        return $this->db->affected_rows();
    }

    public function edit($data, $id){
        $this->db->update('profil', $data, ['id' => $id]);
        return $this->db->affected_rows();
    }

    public function delete($id)
    {
        $this->db->delete('profil', ['id' => $id]);
        return $this->db->affected_rows();   
    }
}
