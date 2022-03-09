package ir.mohammadhf.alibabainternationaltask.feature.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.mohammadhf.alibabainternationaltask.R
import ir.mohammadhf.alibabainternationaltask.databinding.FragmentMenuBinding
import ir.mohammadhf.alibabainternationaltask.feature.SharedViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MenuFragment : Fragment() {
    private val menuViewModel: MenuViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    private var _binding: FragmentMenuBinding? = null
    private val binding
        get() = _binding!!

    @Inject
    lateinit var menuUsersAdapter: MenuUsersAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            usersRv.adapter = menuUsersAdapter

            destEt.addTextChangedListener {
                menuViewModel.travelDestText = it.toString()
            }

            letsGoBtn.setOnClickListener {
                sharedViewModel.setDestination(menuViewModel.travelDestText)
                findNavController().navigate(R.id.action_menuFragment_to_selectFlightFragment)
            }
        }

        menuViewModel.run {
            loadUsers()

            users.observe(viewLifecycleOwner) { users ->
                users?.let {
                    binding.loadingPb.visibility = View.GONE
                    menuUsersAdapter.submitList(it)
                }
            }

            destination.observe(viewLifecycleOwner) {
                binding.letsGoBtn.isEnabled = it
            }
        }

        sharedViewModel.run {
            destination.observe(viewLifecycleOwner, Observer {
                binding.destEt.setText(it)
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}