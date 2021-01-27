<?php

class Buku_m extends CI_Model{

    public function getAll($id = null ){
        if($id === null){

            return $this->db->get('buku')->result_array();
        }else{
            return $this->db->get_where('buku', ['id' => $id])->result_array();
        }
    }

    public function create($data){
        
        $this->db->insert('buku', $data);
        return $this->db->affected_rows();
    }

    public function edit($data, $id){
        $this->db->update('buku', $data, ['id' => $id]);
        return $this->db->affected_rows();
    }

    public function delete($id)
    {
        $this->db->delete('buku', ['id' => $id]);
        return $this->db->affected_rows();   
    }
}